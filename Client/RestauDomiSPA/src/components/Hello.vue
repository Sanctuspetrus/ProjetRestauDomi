<template>
	<div class="hello">
		<sidebar :liens="liens"></sidebar>
		<div class="col-md-9">
			<img class="logo" src="~assets/Pizza-icon.png">
			<h1>Bienvenue sur Pizza Yolo</h1>
			<h2>Votre premier choix question pizza</h2>
			<ul>
				<li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
				<li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
				<li><a href="https://gitter.im/vuejs/vue" target="_blank">Gitter Chat</a></li>
				<li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
				<br>
				<li><a href="http://vuejs-templates.github.io/webpack/" target="_blank">Docs for This Template</a></li>
			</ul>
			<h2>Ecosystem</h2>
			<ul>
				<li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>
				<li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>
				<li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>
				<li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>
			</ul>
		</div>
	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
export default {
	name: 'hello',
	components: {
		sidebar
	},
	data () {
		return {
			logo: '../assets/Pizza-icon.png',
			liens: [{
				name: 'Pizzas',
				url: '/pizzas'
			}]
		}
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	h1, h2 {
		font-weight: normal;
	}

	ul {
		list-style-type: none;
		padding: 0;
	}

	li {
		display: inline-block;
		margin: 0 10px;
	}

	a {
		color: #f9a400;
	}
</style>
