<template>


  <div class="creation">

    <div class="panel panel-default">
      <div class="panel-heading" style="font-weight:bold; font-size:30px">Création de votre pizza</div>
      <div class="panel-body">
        <div class="row">
          <div class="col-sm-7">
            <div class="panel panel-default">
              <img width="50%" height="50%" src="~assets/pizzadessin.jpg">
            </div>
          </div>
          <div class="col-sm-4">
            <div class="panel panel-default">
              <p>Nom de la pizza: <input type="text" name="" v-model="pizzaName"></p>
              <div class="dropdown">
                Pâte : <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">{{pateName}}
                  <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                  <li v-for="dough in allDoughs">  </li>
                </ul>
              </div>
              Ingrédients :
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <button type="submit" @click="" class="btn btn-warning btn-lg pull-right" style="margin-right: 50px">Valider</button>
  </div>

</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'creationPizza',
  created () {
    this.$store.dispatch('getAllPizzas')
  },
  components: {
  },
  props: {
  },
  computed: {

    ...mapGetters([
      'allIngredients',
      'allDoughs'
    ])
  },
  data() {
    return {
      pizzaName: '',
      pateName: 'choisissez votre pâte'
    }
  },
  watch: {
  },
  methods: {
    ...mapActions([

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
