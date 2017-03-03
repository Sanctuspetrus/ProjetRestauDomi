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
			  <a class="navbar-brand" href="#">Start Bootstrap</a>
		  </div>
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			  <ul class="nav navbar-nav">
				  <li>
					  <a href="#">About</a>
				  </li>
				  <li>
					  <a href="#">Services</a>
				  </li>
				  <li>
					  <a href="#">Contact</a>
				  </li>
			  </ul>
		  </div>
		  <!-- /.navbar-collapse -->
	  </div>
	  <!-- /.container -->
  </nav>
</template>

<script>
export default {
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
