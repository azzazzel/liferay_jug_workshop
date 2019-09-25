const loadVue = () => {
  const promise = new Promise((resolve, reject) => {
    if (typeof Vue === "undefined") {
      const script = document.createElement('script');
      script.setAttribute('src', 'https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js');
      
      script.addEventListener('load', () => {
        resolve();
      });
      
      document.head.appendChild(script);
    } else {
      resolve()
    }
  });

  return promise;
}

const mountComponent = () => {
console.log('mounting');
  const vm = new Vue({
      el: '#jugLeadersApp',
      data: {
        people: []
      },
      mounted() {
        $.getJSON("/o/jug-leaders/BG JUG Team", function(result) {
          vm.people = result;
        })
      }
    });
};

loadVue().then(mountComponent);