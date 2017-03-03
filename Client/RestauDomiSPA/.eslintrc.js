// http://eslint.org/docs/user-guide/configuring

module.exports = {
  root: true,
  parser: 'babel-eslint',
  parserOptions: {
    sourceType: 'module'
  },
  env: {
    browser: true,
  },
  // https://github.com/feross/standard/blob/master/RULES.md#javascript-standard-style
  extends: 'standard',
  // required to lint *.vue files
  plugins: [
    'html'
  ],
  // add your custom rules here
  'rules': {
    // allow paren-less arrow functions
    'arrow-parens': 0,
    // allow async-await
    'generator-star-spacing': 0,
    // allow debugger during development
    'no-debugger': process.env.NODE_ENV === 'production' ? 2 : 0,
	// allow paren-less arrow functions
    'arrow-parens': 0,
    // allow debugger during development
    'no-debugger': process.env.NODE_ENV === 'production' ? 2 : 0,
	// tabulation
	'indent': ["warn", "tab"],
	// indent
	'indent': 0,
	// spaced-comment
	'spaced-comment': ["off"],
	// quotes
	'quotes': 'warn',
	// semi
	'semi': ["warn", "never"],
	// space-before-blocks
	'space-before-blocks': 'warn',
	// no-trailing-spaces
	'no-trailing-spaces': 'warn',
	// space-before-function-paren
	'space-before-function-paren': 'off',
	// space-infix-ops
	'space-infix-ops': 'warn',
	// comma-spacing
	'comma-spacing': 'warn',
	// no-unused-vars
	'no-unused-vars': 'warn',
	// padded-blocks
	'padded-blocks': 'warn',
	// spaced-comment
	'spaced-comment': 'warn',
	// no-mixed-spaces-and-tabs
	'no-mixed-spaces-and-tabs': 'off',
	'no-tabs': 'off'
  }
}
