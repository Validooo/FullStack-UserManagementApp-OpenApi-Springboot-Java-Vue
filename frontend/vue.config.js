const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  publicPath: '/FullStack-UserManagementApp-OpenApi-Springboot-Java-Vue/',
  transpileDependencies: true,
  devServer: {
    port: 3000 // Change to the desired port number
  }
})
