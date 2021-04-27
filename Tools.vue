<template>
    
    <div>
     <!-- <v-btn raised class="primary mx-12 mt-16" @click="onPick()">Upload Image</v-btn>
     <input type="file" style="display:none" ref="fileInput" accept="image/*"  @change="onFilePicked"> -->

   
<v-dialog v-model="dialog" width="50%">
            <template v-slot:activator="{ on, attrs }">
                    <v-btn color="success" dark  v-bind="attrs" v-on="on"  class="mt-10 mb-3 ml-3 px-16">
                            <v-icon left >add</v-icon>
                            <v-span style="font-size:150%">
                                    اضافه کردن
                            </v-span>
                                    
                            </v-btn>
                        </template>

                                <v-card>
                                    <v-card-title  class="headline grey lighten-2" dir="rtl">
                                    اضافه نمودن محصول جدید
                                    </v-card-title>
                                    <v-card-text>
                                <v-form>
                                     <v-container>
                                        <v-row > 
                                            <v-col cols="12" sm="6" >
                                            <v-text-field
                                                label="نام محصول  "
                                                outlined
                                                dir="rtl"
                                                v-model="name"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="نوعیت "
                                                outlined
                                                 dir="rtl"
                                                v-model="kind"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="تعداد"
                                                outlined
                                                 dir="rtl"
                                                v-model="number"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="قیمت فروش"
                                                outlined
                                                 dir="rtl"
                                                v-model="sell"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12">
                                            <v-text-field
                                                label="قیمت خرید "
                                                outlined
                                                 dir="rtl"
                                                v-model="shopping"
                                            ></v-text-field>
                                            </v-col>
                                            <div >
                                            <v-btn  raised color="success" class="mx-4" @click="onPick()">اضافه نمودن عکس محصول</v-btn>
                                            <input  type="file" style="display:none;float:right" ref="fileInput" accept="image/*"  @change="onFilePicked">
                                            </div>
                                           
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
                                        @click="dialog = false "
                                    >
                                        انصراف
                                    </v-btn>
                                    <v-btn
                                        color="success"
                                        style="font-size:18px "
                                        @click=" saveTools() ,  dialog = false"
                                    >
                                        ذخیره کردن
                                    </v-btn>
                                   
                                    </v-card-actions>
                                    </v-card>
                                 </v-dialog>
                                 <v-divider class="mx-4 inset" style="color:red" vertical="">
                                </v-divider>
                                <v-toolbar-title class="mr-16 display-1  mt-10 " style="color:red;float:right">
                                 موجودی انبار
                                </v-toolbar-title>
                                <hr>


                       <v-simple-table height="300px">
                                  <template v-slot:default>
                                            <thead>
                                                  <tr>
            
                                                    <th>قیمت فروش</th>
                                                    <th>قیمت خرید</th>
                                                    <th>تعداد</th>
                                                    <th>نوعیت</th>
                                                    <th>نام محصول</th>
                                                    <th>عکس</th>
            
                                                  </tr>
                                                    </thead>
                                                    <tbody>

                                                        <tr
                                                        v-for="item in desserts"
                                                        :key="item.id"
                                                        >
                                                        <td>{{item.sell}}</td>
                                                        <td>{{item.shopping}}</td>
                                                        <td>{{item.number}}</td>
                                                        <td>{{item.kind}}</td>
                                                        <td>{{item.name}}</td>
                                                        <td><img :src="imageurl" style=" width: 50px ;  height: 50px;"></td>
                                                        </tr>
                                                    </tbody>
                                                    </template>
                                                </v-simple-table>






                        
    </div>
</template>
<script>
import Tools from '../api/Tools'

export default {

        data(){
            const tool={
                name:null,
                kind:null,
                number:null,
                sell:null,
                shopping:null
            }
            return{
                tool,
                dialog:false,
                imageurl:'',    
                     desserts: [{}]

            }      
        },
           async mounted(){
           const response = await Tools.getAllTools();
           this.desserts = response.data; 

   },

        methods:{
            onPick(){
                this.$refs.fileInput.click()
            },
           onFilePicked(event) {
                const files =event.target.files
                let filename = files[0].name
                if(filename.lastIndexOf('.')<=0){
                    return alert("please enter correct file")
                }
                const fileReader = new  FileReader()
                fileReader.addEventListener('load' , ()=>{
                    this.imageurl = fileReader.result
                 })
                 fileReader.readAsDataURL(files[0])
                this.desserts.image = this.imageurl   
           },
          async saveTools(){
           const Tools1={
               name : this.name,
               kind : this.kind,
               number:this.number,
               sell : this.sell,
               shopping : this.shopping,
           }
           const response= await Tools.AddTools(Tools1);
           console.log(response);
           this.desserts.push(response.data);
       }
  

        }

}
</script>
<style>


</style>