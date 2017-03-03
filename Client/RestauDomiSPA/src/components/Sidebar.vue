<template>
	<!-- Sidebar -->
		<div class="col-md-3">
			<p class="lead">PizzaYolo</p>
			<div class="list-group">
				<a v-for="lien in liens" :href="lien.url" class="list-group-item">{{lien.name}}</a>
			</div>
		</div>
</template>

<script>
export default {
	props: {
		liens: Array
	},
	data () {
		return {
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
