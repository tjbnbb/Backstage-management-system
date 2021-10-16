<template>
  <div id="app">
    <vue-particles
      id="particles-js"
      color="#dedede"
      :particle-opacity="0.7"
      :particles-number="40"
      shape-type="star"
      :particle-size="4"
      lines-color="#FFFFFF"
      :lines-width="2"
      :line-linked="true"
      :line-opacity="0.4"
      :lines-distance="150"
      :move-speed="3"
      :hover-effect="true"
      hover-mode="grab"
      :click-effect="true"
      click-mode="push"
      class="cash"
    />
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style scoped>
#particles-js{
      width: 100%;
      height: calc(100% - 100px);
      position: absolute;/*设置absolute,其他DIV设置为relative，这样这个例子效果就作为背景*/
  }
</style>
