<template>
    <v-flex> 
            <v-app>
                <v-container>
                    <template>
                        <v-data-table  show-select item-key="id"
                         v-model="selected"
                        :headers="headers"
                        :items="desserts"   
                        :single-select="singleSelect"
                        :search="search"
                        class="style-table" 
                        style="color:darkgreen "
                        >
                        <template v-slot:top>
                            <v-toolbar flat>
                                <v-dialog v-model="dialog2" width="50%">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-btn color="success" dark  v-bind="attrs" v-on="on" >
                                    <v-icon left>add</v-icon>
                                    اضافه کردن
                                    </v-btn>
                                </template>

                                <v-card>
                                    <v-card-title  class="headline grey lighten-2" dir="rtl">
                                       اضافه نمودن مصارف روزمره
                                    </v-card-title>
                                    <v-card-text>
                                <v-form>
                                     <v-container>
                                        <v-row > 
                                            <v-col cols="12" sm="6" >
                                            <v-text-field
                                                label="نام محصول خریداری شده "
                                                outlined
                                                dir="rtl"
                                                v-model="name1"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label=" تعداد"
                                                outlined
                                                dir="rtl"
                                                v-model="number"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label=" قیمت"
                                                outlined
                                                dir="rtl"
                                                v-model="price"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label=" مناسبت آن"
                                                outlined
                                                 dir="rtl"
                                                v-model="relation"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="برداشت شخصی"
                                                outlined
                                                 dir="rtl"
                                                v-model="brdashet"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label=" تاریخ"
                                                outlined
                                                 dir="rtl"
                                                v-model="date"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" >
                                            <v-text-field
                                                label="روز"
                                                outlined
                                                 dir="rtl"
                                                v-model="day"
                                            ></v-text-field>
                                            </v-col>
                                        </v-row>
                                        </v-container>
                                    </v-form>
                                    </v-card-text>
                                    <v-divider></v-divider>
                                    <v-card-actions>
                                    <v-spacer></v-spacer>
                                     <v-btn
                                        color="error"
                                        style="font-size:18px "
                                        @click="dialog2 = false "
                                    >
                                        انصراف
                                    </v-btn>
                                    <v-btn
                                        color="success"
                                        style="font-size:18px "
                                        @click=" saveExpensive(), dialog2 = false"
                                    >
                                        ذخیره کردن
                                    </v-btn>
                                    </v-card-actions>
                                    </v-card>
                                 </v-dialog>
                                <v-spacer class="ml-10">
                                    <v-text-field
                                        v-model="search"
                                        dir="rtl"
                                        append-icon="mdi-magnify"
                                        label="جستجو"
                                        single-line
                                        hide-details>
                                    </v-text-field>
                                </v-spacer>
                                <v-divider class="mx-4 inset" style="color:red" vertical="">
                                </v-divider>
                             <v-toolbar-title class="ml-2" style="color:red">
                                    لیست مصارف روزانه
                             </v-toolbar-title> 
                            </v-toolbar>
                        </template>
                        </v-data-table>
                    </template>
                </v-container>
            </v-app>
        </v-flex>
</template>


<script>
import expense from "../api/expensive"
export default {
    data(){
        const expens1={
            name1:null,
            number:null,
            price:null,
            relation:null,
            brdashet:null,
            date:null,
            day:null
        }
        return{
            search:'',
            expens1,
            dialog2:false,
            singleSelect: false,
            selected: [],

// this is for v-tabel-data in expenses page
             headers: [
          {
            align: 'start',
            sortable: false,
            value: 'name',
            
          },
          {text: 'روز', value: 'day'},
          {text: 'تاریخ ', value: 'date'},
          {text: 'برداشت شخصی', value: 'brdashet'},
          {text:'مناسبت آن',value:'relation'},
          {text: 'قیمت', value: 'price'},
          {text:'تعداد ' , value:'number'},
          {text:'نام محصول خریداری شده' , value:'name1'}
          
        ],
        desserts: [{}]
        }
    },
             async mounted(){
           const response = await expense.getAllexpense();
           this.desserts = response.data; 
   },
    methods:{
            async saveExpensive(){
           const expens={
               name1 : this.name1,
               number : this.number,
               price:this.price,
               relation : this.relation,
               brdashet : this.brdashet,
               date:this.date,
               day:this.day
           }
           const response= await expense.Addexpense(expens);
           console.log(response);
           this.desserts.push(response.data);
       }
    }
}
</script>