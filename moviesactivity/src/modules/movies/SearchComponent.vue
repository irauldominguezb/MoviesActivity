<template>
  <b-card>
    <b-row>
        <b-col>
            <b-form-group
                id="fieldset-search"
                label-for="input-search"
          >
            <b-form-input
                id="search"
                pill
                :placeholder="'Buscar...'"
                style="border: thin 0.4px gray;"
                class="sticky-top"
            >
            </b-form-input>

          </b-form-group>
        </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
    name: 'SearchComponent',
}
</script>

<style>
.sticky-top{
  position: -webkit-sticky;
    position: sticky;
    top: 0;
    z-index: 102; 

}
</style>