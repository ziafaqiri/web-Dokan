import '@fortawesome/fontawesome-free/css/all.css';
import 'material-design-icons-iconfont';

import Vue from "vue";
import Vuetify from "vuetify/lib/framework";
// import VueGoogleCharts from 'vue-google-charts'
// Vue.use(VueGoogleCharts);

import Donut from 'vue-css-donut-chart';
import 'vue-css-donut-chart/dist/vcdonut.css';
 
Vue.use(Donut);
Vue.use(Vuetify);

export default new Vuetify({
    icons:{
        iconfont:'md' || 'fa'
    },
});
