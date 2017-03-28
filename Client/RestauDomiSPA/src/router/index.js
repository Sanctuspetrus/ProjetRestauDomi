import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Pizzas from 'components/Pizzas'
import Commandes from 'components/Commandes'
import Compte from 'components/Compte'

Vue.use(Router)

export default new Router({
	routes: [
		{
			path: '/',
			name: 'Hello',
			component: Hello
		},
		{
			path: '/lacarte',
			name: 'lacarte',
			component: Pizzas
		},
		{
			path: '/commandes',
			name: 'commandes',
			component: Commandes
		},
		{
			path: '/compte',
			name: 'compte',
			component: Compte
		}
	]
})
