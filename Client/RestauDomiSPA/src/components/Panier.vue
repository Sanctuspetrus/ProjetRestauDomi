<template>


	<div class="container">
		<h2>Contenu du panier</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Pizza</th>
					<th>Quantité</th>
					<th>Prix</th>
				</tr>
			</thead>
			<tbody>

				<tr v-for="content in cartContent">
					<td>{{content.pizza.name}}</td>
					<td><input type="text" class="btn btn-info btn-xs input-class" size="1" name="" value="-" @click="delPizzaFromCart(content.pizza)">{{content.amount}}<input type="text" class="btn btn-info btn-xs input-class" name="" size="1" value="+" @click="addPizzaToCart(content.pizza)"></td>
					<td>{{content.pizza.price}}€  </td>
				</tr>
			</tbody>
		</table>
		<p>Total : {{totalPrice}}€</p>
		<button v-if="cartContent.length > 0" type="submit" @click="commander" class="btn btn-warning">Commander</button>
	</div>

</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
	name: 'panier',
	components: {
	},
	props: {
	},
	computed: {
		totalPrice() {
			var total = 0
			for (var i = 0; i < this.cartContent.length; i++) {
				total = total + this.cartContent[i].pizza.price * this.cartContent[i].amount
			}
			return total
		},
		...mapGetters([
			'allPizzas',
			'cartContent'
		])
	},
	data() {
		return {
		}
	},
	watch: {
	},
	methods: {
		paiement() {
			this.commander()
			this.$toasted.success('Commande enregistrée!', {duration: 1000})
		},
		...mapActions([
			'commander',
			'addPizzaToCart',
			'delPizzaFromCart'
		])
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

	.input-class {
		margin-left: 5px;
		margin-right: 5px;
	}

	a {
		color: #f9a400;
	}
</style>
