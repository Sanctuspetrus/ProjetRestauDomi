// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from 'src/App'
import router from 'src/router'
import store from 'src/store'
import resources from 'src/resources'
import Toasted from 'vue-toasted'
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon.vue'
import vSelect from 'vue-select'

Vue.component('icon', Icon)
Vue.use(Toasted)
Vue.component('v-select', vSelect)

/* eslint-disable no-new */
new Vue({
	el: '#app',
	router,
	store,
	resources,
	template: '<App/>',
	components: { App }
})
