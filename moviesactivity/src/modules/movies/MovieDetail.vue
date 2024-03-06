<template>
    <div>
        <div class="container">
            <b-card
                class="shadow-lg mt-3"
            >
                <template slot="header" >
                    <b-row class="pt-1">
                        <b-col lg="12">
                            <h5 class="text-secondary text-center">
                                Detalle de película
                            </h5>
                        </b-col>
                    </b-row>
                </template>
                <b-row>
                    <b-col lg="12" class="mb-3">
                        <b-button
                            variant="primary"
                            to="/"
                            class="float-right"
                        >
                            <b-icon icon="arrow-left"></b-icon>
                            Volver
                        </b-button>
                    </b-col>
                </b-row>
                <div class="container pt-3">
                    <b-row>
                        <b-col cols="12" lg="8">
                            <b-row>
                                <b-col cols="12" class="mt-2 d-flex justify-content-between">
                                    <h5>
                                Director: <span class="text-secondary">Nombre del director</span>
                                    </h5>
                                </b-col>
                            </b-row>
                            <b-row>
                                <b-col cols="12" class="mt-2">
                                    <h5>
                                Año: <span class="text-secondary">Año de estreno</span>
                                    </h5>
                                </b-col>
                            </b-row>
                            <b-row>
                                <b-col cols="12" class="mt-2">
                                    <h5>
                                Género: <span class="text-secondary">Género</span>
                                    </h5>
                                </b-col>
                            </b-row>
                        </b-col>
                        <b-col cols="12" lg="4" class="text-end">
                            <b-img
                                fluid
                                thumbnail
                                src="https://via.placeholder.com/260"
                                alt="Image"
                                rounded
                            ></b-img>
                        </b-col>
                    </b-row>
                </div>
            </b-card>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MovieDetail',
}
</script>

<style>

</style>