<template>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

				<router-link class="navbar-brand" to="/"><span><img class="logo" src="~assets/pizza-iconx32.png"></span>Pizza Yolo</router-link>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<router-link to="/lacarte">La carte</router-link>
					</li>
					<li>
						<router-link to="/creezVotrePizza">Créez votre pizza</router-link>
					</li>
					<li>
						<router-link to="/commandes">Commandes</router-link>
					</li>
					<li>
						<router-link to="/panier">Panier({{nbProduitDansPanier}})</router-link>
					</li>
					<li>
						<router-link to="/compte"><img class="logo" src="~assets/account-icon.png"></router-link>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
	data () {
		return {
		}
	},
	computed: {
    ...mapGetters([
      'cartContent'
    ]),
		nbProduitDansPanier() {
			var total = 0
			for (var i = 0; i < this.cartContent.length; i++) {
				total = total + this.cartContent[i].amount
			}
			return total
		}
  },
	method: {

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
