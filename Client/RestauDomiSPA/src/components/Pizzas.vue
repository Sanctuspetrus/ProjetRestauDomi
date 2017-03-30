<template>
	<div class="pizzas">
		<ul>
			<li v-for="pizza in listPizzas">
				<pizza-carte
				:name="pizza.name"
				:price="pizza.price"
				:ingredients="pizza.ingredients"
				:dough="pizza.dough"
				:autor="pizza.autor"
				></pizza-carte>
			</li>
		</ul>
		Ingredient:
		<select v-model="ingredientName">
			<option v-for="ing in allIngredients" :value="ing.id">{{ing.name}}</option>
		</select>
		<button @click="addIngredient(ingredientName)">Ajouter</button>
		<ul>
			<li v-for="ing in ingPizza">{{ing}}</li>
		</ul>



		<div class="row">
			<div class="col-sm-4" v-for="pizza in allPizzas">
				<div class="panel panel-default btn-default" @click="addPizzaToCart(pizza), popUp()">
					<div class="panel-heading" style="font-weight:bold; font-size:18px">{{pizza.name}}</div>
					<div class="panel-body">
						<p>{{pizza.price}}€</p>
					</div>
				</div>
			</div>
		</div>
		<button @click="toast">Toast</button>
		
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
			this.$toasted.show("I'm toasted!")
		},
		findIngredientById(id) {
			return this.allIngredients.find(ing => ing.id === id)
		},
		findDoughById(id) {
			return this.allDoughs.find(dough => dough.id === id)
		},
		...mapActions([
			'addIngredient'
		])
	},
	computed: {
		listPizzas () {
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
				pizza.ingredients = ingredients
				pizza.dough = dough
				return pizza
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
