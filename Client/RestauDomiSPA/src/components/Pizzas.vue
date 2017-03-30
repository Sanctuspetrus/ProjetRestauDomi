<template>
	<div class="pizzas">
		cfghfch
		<ul>
			<li v-for="pizza in allPizzas">{{pizza.name}}</li>
		</ul>
		Igredient: <input type="text" name="" v-model="ingredientName">
		<button @click="addIngredient(ingredientName)">Ajouter</button>
		<ul>
			<li v-for="ing in ingPizza">{{ing}}</li>
		</ul>
	</div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import sidebar from 'components/Sidebar'
export default {
	name: 'pizzas',
	components: {
		sidebar
	},
	created() {
		this.$store.dispatch('getAllPizzas')
	},
	methods: mapActions([
		'addIngredient'
	]),
	computed: mapGetters([
		'allPizzas',
		'ingPizza'
	]),
	data () {
		return {
			listPizzas: [],
			ingredientName: ''
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
