// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from 'src/App'
import router from 'src/router'
import store from 'src/store'
import Toasted from 'vue-toasted'
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon.vue'

Vue.component('icon', Icon)
Vue.use(Toasted)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
