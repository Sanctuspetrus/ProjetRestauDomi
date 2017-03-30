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
					<td>{{content.amount}}</td>
					<td>{{content.pizza.price}}€</td>
					<td @click="delPizzaFromCart(content.pizza)">x</td>
				</tr>
			</tbody>
		</table>
		<p>Total : {{totalPrice}}€</p>
		<button type="submit" @click="paiement" class="btn btn-warning">Valider le payement</button>


		<div class="row">
			<div class="col-sm-4" v-for="pizza in allPizzas">
				<div class="panel panel-default" @click="addPizzaToCart(pizza)">
					<div class="panel-heading" style="font-weight:bold; font-size:18px">{{pizza.name}}</div>
					<div class="panel-body">
						<p>{{pizza.price}}€</p>
					</div>
				</div>
			</div>
		</div>



	</template>

	<script>
	import { mapGetters, mapActions } from 'vuex'

	export default {
		name: 'panier',
		created () {
			this.$store.dispatch('getAllPizzas')
		},
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
				alert('Payé !')
			},
			quantity(nom) {
				var qty = 0
				for (var p in this.cartContent) {
					if (nom === p.pizza.name) qty++
				}
				return qty
			},
			...mapActions([
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

		a {
			color: #f9a400;
		}
	</style>
