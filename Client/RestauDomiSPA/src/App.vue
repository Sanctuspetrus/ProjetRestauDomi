<template>
	<div id="app">
		<navigation></navigation>
		<router-view></router-view>
	</div>
</template>

<script>
import navigation from 'components/Navigation'
import sidebar from 'components/Sidebar'

export default {
	name: 'app',
	components: {
		navigation, sidebar
	}
}
</script>

<style>
	#app {
		font-family: 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top: 60px;
	}
</style>
