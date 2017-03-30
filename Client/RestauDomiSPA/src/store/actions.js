import * as mutations from 'store/mutations'

export const addToCart = ({ commit }, product) => {
  if (product.inventory > 0) {
    commit(mutations.ADD_TO_CART, {
      id: product.id
    })
  }
}
