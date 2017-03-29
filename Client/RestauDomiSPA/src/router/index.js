import Vue from 'vue'
import Router from 'vue-router'
import Hello from 'components/Hello'
import Pizzas from 'components/Pizzas'
import Commandes from 'components/Commandes'
import Compte from 'components/Compte'
import Connexion from 'components/Connexion'
import Inscription from 'components/Inscription'
import Panier from 'components/Panier'

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
		},
		{
			path: '/connexion',
			name: 'connexion',
			component: Connexion
		},
		{
			path: '/inscription',
			name: 'inscription',
			component: Inscription
		},
		{
			path: '/panier',
			name: 'panier',
			component: Panier
		}
	]
})
