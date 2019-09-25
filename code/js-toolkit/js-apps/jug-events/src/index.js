import Vue from 'vue/dist/vue.common';
import JugEvents from './JugEvents.vue';
import moment from 'moment';

/**
 * This is the main entry point of the portlet.
 *
 * See https://tinyurl.com/js-ext-portlet-entry-point for the most recent 
 * information on the signature of this function.
 *
 * @param  {Object} params a hash with values of interest to the portlet
 * @return {void}
 */
export default function main({portletNamespace, contextPath, portletElementId, configuration}) {

  Vue.filter('toDate', function (value) {
    if (!value) return ''
    var date = new Date(value);
    console.log('Date is ' + date);
    return moment(date).format('MMM Do');
  })

  new Vue({
    el: `#${portletElementId}`,
    render: h => h(JugEvents)
  });
}