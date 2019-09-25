<template>
  <div>

    <h2 style="text-align: center">
      JUG Events
    </h2>

    <div id="jugEventsApp">
      <div v-cloak>
        <ul class="timeline timeline-spacing-xl">
          <li class="timeline-item" v-for="(event, index) in events" v-bind:key="event.eventId">
            <div class="panel panel-secondary">
              <a v-bind:aria-controls="'panelCollapse' + index" aria-expanded="false" class="collapsed panel-header panel-header-link" data-toggle="collapse" v-bind:href="'#panelCollapse' + index" v-bind:id="'heading' + index" role="tab">

                <span class="panel-title">
                  {{ event.name }}
                </span>
                <div class="timeline-increment">
                  <span class="label label-lg label-secondary">
                    <span class="label-item label-item-expand">{{ event.date | toDate }}</span>
                  </span>  
                </div>
              </a>
              
              <div v-bind:aria-labelledby="'heading' + index" class="collapse panel-collapse" v-bind:id="'panelCollapse' + index" role="tabpanel">

                <div class="panel-body">
                    <div v-if="venues[event.venueId]">
                      <div style="font-variant: small-caps;">Where:</div>
                      <div style="padding-left:15px">{{ venues[event.venueId].name }}</div>
                      <div style="padding-left:15px; font-size:70%; color: gray">{{ venues[event.venueId].address }}</div>
                    </div>
                    <div v-if="event.website">
                      <div style="margin-top:10px; font-variant: small-caps;">Event website:</div>
                      <div style="padding-left:15px">
                        <a v-bind:href="event.website">{{ event.website }}</a>
                      </div>
                    </div>
                    <div v-if="event.talks.length > 0">
                      <div style="margin-top:10px; font-variant: small-caps;">Sessions:</div>
                      <ul>
                        <li v-for="talk in event.talks" v-bind:key="talk.talkId">
                          <a v-bind:href="'/talk/-/talk/' + talk.talkId">
                            {{ talk.title }}
                          </a>
                        </li>
                      </ul>
                    </div>
                </div>
                
              </div>
            </div>
          </li>
        </ul>
      </div>
      <div id="mapid"></div>
    </div>
    
  </div>
</template>

<script>
  module.exports = {
    data: function () {
      return {
        iconsPath: Liferay.ThemeDisplay.getPathThemeImages() + '/lexicon/icons.svg',
        events: [],
        venues: []
      }
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
              console.debug("get-group-events: " + result)
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
                  console.debug("get-event-talks: " + result)
                  ref.talks = result;
                  resolve(ref)
                }
              )
            })
          )
        })
        // Promise.all(promises).then((events) => {
        //   console.debug("events: " + events)
        //   this.events = events;
        // });

        return Promise.all(promises);  

      }

      console.debug("Started JugEvents.vue")

      // getEvents().then((events) => {
      //   getTalks(events)
      // })

      getEvents().then((events) => {
        console.debug("events only: " + events)
        getTalks(events).then((events) => {
          console.debug("events 0: " + events)
          console.debug("events 1: " + this.events)
          this.events = events
          console.debug("events 2: " + this.events)
        })
      })

      Liferay.Service(
        '/cfp.venue/get-group-venues',
        {
          companyId: Liferay.ThemeDisplay.getCompanyId(),
          groupId: Liferay.ThemeDisplay.getScopeGroupId()
        },
        function(result) {
          this.venues = result;
        }
      );
    }
  }
</script>