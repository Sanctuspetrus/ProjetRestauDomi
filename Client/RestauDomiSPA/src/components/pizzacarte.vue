<template>
	<div class="pizzacarte">

	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
import apiPizzas from 'src/api/pizzas'

export default {
	name: 'pizzacarte',
	components: {
		sidebar
	},

	data () {
		var listPizzas = apiPizzas.listPizzas
		return {
			listPizzas: listPizzas
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
