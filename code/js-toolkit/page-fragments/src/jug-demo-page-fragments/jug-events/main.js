const loadLibs = () => {

  jsLibs = [
    [typeof Vue, "https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"],
    [typeof moment, "https://cdn.jsdelivr.net/npm/moment@2.24.0/min/moment.min.js"],
  ]

  function loadLib (obj, url) {
    return new Promise((resolve, reject) => {
      if (obj === "undefined") {
        const script = document.createElement('script');
        script.setAttribute('src', url);
        
        script.addEventListener('load', () => {
          console.log('Loaded: ' + url);
          resolve();
        });
        
        document.head.appendChild(script);
      } else {
        console.log('Skipped (already loaded): ' + url);
        resolve()
      }
    });
  }

  var jsLibsPromises = [];
  jsLibs.forEach (
    function(lib){
      jsLibsPromises.push(loadLib(lib[0], lib[1]));
    }
  )

  // const vuePromise = new Promise((resolve, reject) => {
  //   if (typeof Vue === "undefined") {
  //     const script = document.createElement('script');
  //     script.setAttribute('src', 'https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js');
      
  //     script.addEventListener('load', () => {
  //       console.log('Vue loaded');
  //       resolve();
  //     });
      
  //     document.head.appendChild(script);
  //   } else {
  //     console.log('Vue NOT loaded');
  //     resolve()
  //   }
  // });

  // const momentPromise = new Promise((resolve, reject) => {
  //   if (typeof moment === "undefined") {
  //     const script = document.createElement('script');
  //     script.setAttribute('src', 'https://cdn.jsdelivr.net/npm/moment@2.24.0/min/moment.min.js');
      
  //     script.addEventListener('load', () => {
  //       console.log('Moment loaded');
  //       resolve();
  //     });
      
  //     document.head.appendChild(script);
  //   } else {
  //     console.log('Moment NOT loaded');
  //     resolve()
  //   }
  // });

  // return Promise.all([vuePromise,momentPromise]);
  return Promise.all(jsLibsPromises);
}

const mountComponent = () => {
  console.log('mounting');

  Vue.filter('toDate', function (value) {
    if (!value) return ''
    var date = new Date(value);
    console.log('Date is ' + date);
    return moment(date).format('MMM Do');
  })

  // Vue.filter('toYear', function (value) {
  //   if (!value) return ''
  //   var date = new Date(value);
  //   return moment(date, 'YYYY')
  // })

  const vm = new Vue({
    el: '#jugEventsApp',
    data: {
      events: [],
      venues: []
    },
    mounted() {

      function getEvents() {
        return new Promise((resolve, reject) => {
          Liferay.Service(
            '/cfp.event/get-group-events',
            {
              companyId: Liferay.ThemeDisplay.getCompanyId(),
              groupId: Liferay.ThemeDisplay.getScopeGroupId()
            },
            function(result) {
              resolve(result)
            }
          );
        });
      }

      function getTalks(events) {
        var promises = [];
        events.forEach (function(ref){
          promises.push(
            new Promise((resolve, reject) => {
              Liferay.Service(
                '/cfp.talk/get-event-talks',
                {
                  eventId: ref.eventId
                },
                function(result) {
                  ref.talks = result;
                  resolve(ref)
                }
              )
            })
          )
        })
        Promise.all(promises).then((events) => {
          vm.events = events;
        });
      }

      getEvents().then((events) => {
        getTalks(events)
      })

      Liferay.Service(
        '/cfp.venue/get-group-venues',
        {
          companyId: Liferay.ThemeDisplay.getCompanyId(),
          groupId: Liferay.ThemeDisplay.getScopeGroupId()
        },
        function(result) {
          vm.venues = result;
        }
      );
    }
  });
};

loadLibs().then(mountComponent);