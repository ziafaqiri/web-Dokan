<template>
    <nav>
        <v-navigation-drawer v-model="drawer" dark app class="grey darken-3 py-0" right >
            <v-container>
                <v-row>
                    <v-img src="../../public/image/carousel/dokan.jpg" style="border:1px solid grey"></v-img>
                </v-row>
            </v-container>

            <v-list  nav dir="rtl">  
                <v-list-item router to="/" >
                    <v-list-item-action>
                        <v-icon small >fas fa-tachometer-alt </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title class="mx-10">
                            داشبورد
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                <v-list-item router to="/add/people">
                    <v-list-item-action>
                        <v-icon small>fas fa-users </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title class="mx-10">افراد</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                <v-list-item router to="/Tools">
                    <v-list-item-action>
                        <v-icon small>fas fa-tools </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title class="mx-10">
                           اجناس
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                <v-list-item router to="/sell">
                    <v-list-item-action>
                        <v-icon small>fas fa-chart-line </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title class="mx-10 ">
                           فروشات
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                <v-list-item router to="/expenses">
                    <v-list-item-action>
                        <v-icon small> fas fa-clipboard-list </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title class="mx-10 " >
                            مصارف
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
            <v-layout row style="position:absolute ; bottom:0"> 
                <v-flex class="my-2 mx-5">
                   <v-tooltip top>
                        <template v-slot:activator="{on}">
                            <v-list-item-avatar v-on="on">
                                    <v-img src="../../public/image/avatar.png"></v-img>
                            </v-list-item-avatar>
                        </template>
                        <span>پروفایل</span>
                    </v-tooltip>
                </v-flex>
                <v-flex class="my-5">
                    <v-tooltip top>
                        <template v-slot:activator="{on}">
                            <v-btn text icon v-on="on">
                                <v-icon right>fas fa-sign-out-alt</v-icon>
                            </v-btn>
                        </template>
                        <span>خروج</span>
                    </v-tooltip>
                </v-flex>
            </v-layout>



        </v-navigation-drawer>
      
    </nav>
</template>
<script>
export default {
    data:()=>({
        drawer:true
    })
}
</script>
<style>

    .a{
        font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    }
    

</style>