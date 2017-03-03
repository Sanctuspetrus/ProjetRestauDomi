<template>
	<div class="pizzas">
		
	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
export default {
	name: 'pizzas',
	components: {
		sidebar
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
