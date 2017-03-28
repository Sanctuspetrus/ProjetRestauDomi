<template>
	<div class="container">
		<div class="row">
			<div class="col-md-2" v-for="pizza in listPizzas">
				<pizza :pizza="pizza"></pizza>
			</div>
		</div>
	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
import pizza from 'components/pizza'
import apiPizzas from 'src/api/pizzas'
export default {
	name: 'pizzas',
	components: {
		sidebar, pizza
	},
	data () {
		var listPizzas = []
		
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
