<template>
  <div class="rich">
    <div class="rich-nav flex">
      <div class="nav-item" @click.stop="selectBlod">Blod</div>
      <div class="nav-item" style="color: red;" @click.stop="selectColor('red')">Red</div>
      <div class="nav-item" style="color: #4169E1;" @click.stop="selectColor('#4169E1')">Blue</div>
    </div>
    <div class="rich-content">
      <div
        id="richText"
        contenteditable="true"
        v-html="content"
        @keydown="keyListen"
        @blur.capture.stop="saveAction"
      ></div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    width: { type: String, default: "auto" },
    height: { type: String, default: "auto" },
    content: { type: String, default: "" },
  },
  data() {
    return {};
  },
  methods: {
    saveAction() {
      let value = this.getContent();
      this.$emit("saveAction", value);
    },
    selectBlod() {
      document.execCommand("ForeColor", false, "black");
      document.execCommand("Bold");
    },
    selectColor(color) {
      document.execCommand("ForeColor", false, color);
      document.execCommand("Bold");
    },
    getContent() {
      let target = document.getElementById("richText");
      let content = target.innerHTML;
      return content;
    },
    keyListen() {
      // 1.监听tab
      if (event.keyCode === 9) {
        document.execCommand("insertText", false, "    ");
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.rich {
  background-color: $sj-tip-lower;
  padding: 0.5rem;
  max-width: 100%;
  .rich-nav {
    padding-bottom: 0.5rem;
    border-bottom: 1px solid $sj-tip;
    .nav-item {
      margin-right: 0.5rem;
      text-align: center;
      cursor: pointer;
      line-height: 2rem;
      // width: 2rem;
      height: 2rem;
      padding: 0rem 0.5rem;
      background-color: $sj-tip;
      &:hover {
        background-color: $sj-white;
      }
    }
  }
  .rich-content {
    overflow-y: auto;
    word-wrap: break-word;
    max-height: 45rem;
    #richText {
      padding: 0.5rem 0rem;
      &:focus {
        outline: 0rem;
      }
    }
  }
}
</style>
