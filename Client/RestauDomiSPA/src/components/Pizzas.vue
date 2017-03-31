<template>
	<div class="pizzas">
		<div class="row">
			<div class="col-sm-4" v-for="pizza in listPizzas">
				<pizza-carte
				:name="pizza.name"
				:price="pizza.price"
				:ingredients="pizza.ingredients"
				:dough="pizza.dough"
				:autor="pizza.autor"
				></pizza-carte>
				<button @click="clickToAddPizza(pizza)">Ajouter au panier</button>
			</div>
		</div>

	</div>



</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import sidebar from 'components/Sidebar'
import pizzaCarte from 'components/pizzaCarte'
export default {
	name: 'pizzas',
	components: {
		sidebar, pizzaCarte
	},
	created () {
		this.$store.dispatch('getAllPizzas')
	},
	methods: {
		toast () {
			this.$toasted.info("I'm toasted!", {duration: 500})
		},
		clickToAddPizza(pizza) {
			this.addPizzaToCart(pizza)
			this.$toasted.success(pizza.name + ' ajoutée au panier.', {duration: 1000})
		},
		findIngredientById(id) {
			return this.allIngredients.find(ing => ing.id === id)
		},
		findDoughById(id) {
			return this.allDoughs.find(dough => dough.id === id)
		},
		...mapActions([
			'addIngredient',
			'addPizzaToCart'
		])
	},
	computed: {
		listPizzas () {
			// Remplace les id par les ingredients (et pâtes) correspondants
			return this.allPizzas.map(pizza => {
				var ingredients = []
				var dough = { name: '', price: 0 }
				for (var ing in pizza.ingredients) {
					var ingredient = this.findIngredientById(pizza.ingredients[ing])
					if (ingredient !== undefined) {
						ingredients.push(ingredient)
					}
				}
				var d = this.findDoughById(pizza.ingredients[d])
				if (d !== undefined) {
					dough = d
				}
				var res = JSON.parse(JSON.stringify(pizza))
				res.ingredients = ingredients
				res.dough = dough
				return res
			})
		},
		...mapGetters([
			'allPizzas',
			'allIngredients',
			'allDoughs',
			'ingPizza'
		])
	},
	data () {
		return {
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
