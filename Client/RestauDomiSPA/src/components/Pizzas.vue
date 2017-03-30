<template>
	<div class="pizzas">
		cfghfch
		<ul>
			<li v-for="pizza in listPizzas">{{pizza.name}}</li>
		</ul>
	</div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import sidebar from 'components/Sidebar'
import {listPizzas} from 'src/api/pizzas'
export default {
	name: 'pizzas',
	components: {
		sidebar
	},
	ready(){
		listPizzas.then(yolo => {
			this.listPizzas
		})
	},
	 methods: mapActions([
    'addToCart'
  ]),
	data () {
		return {
			listPizzas: []
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
