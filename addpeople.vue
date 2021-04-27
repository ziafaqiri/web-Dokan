<template>
<div>
    <v-layout row style="float:right">
        <v-flex  class="ma-10 mt-0 mb-0 mr-3">
            <v-app style="background-color:rgba(150, 142, 142, 0.1) ;" >
                <v-container class="mr-3 mt-16 "  >
                    <h3 class="mb-10 ; ml-16 ;" >لیست  افراد</h3>
                    <hr>
                    <v-list-item router to="/add/people" v-on:click="showTableBorrwer()" dir="rtl">
                    <v-list-item-action class="mx-5">
                        <v-icon small >fas fa-user-plus</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title style="color:black">
                            لیست قرضداران
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                   <v-list-item router to="/add/people" v-on:click="showTableCredaitor()" dir="rtl">
                    <v-list-item-action class="mx-5">
                        <v-icon small>fas fa-user-plus</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title style="color:black">
                             لیست طلبکاران
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>

                   <v-list-item router to="/add/people" v-on:click="showTableStaff()" dir="rtl" >
                    <v-list-item-action class="mx-5">
                        <v-icon small>fas fa-user-plus</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title style="color:black">
                            لیست کارمندان
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
                </v-container>
            </v-app>
        </v-flex>
</v-layout>
   
        <!-- Crediator List  and add Crediator -->

         <v-flex class="md9" v-show=" CredaitorList"> 
            <v-app>
                <v-container>
                    <template>
                        <v-data-table  show-select item-key="id"
                         v-model="selected"
                        :headers="headers1"
                        :items="desserts1"   
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
                                    اضافه نمودن شخص جدید
                                    </v-card-title>
                                    <v-card-text>
                                <v-form>
                                     <v-container>
                                        <v-row > 
                                            <v-col cols="12" sm="6" >
                                            <v-text-field
                                                label="نام "
                                                outlined
                                                dir="rtl"
                                                v-model="name"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="نام پدر"
                                                outlined
                                                 dir="rtl"
                                                v-model="fathername"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="مقدار پول"
                                                outlined
                                                 dir="rtl"
                                                v-model="money"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="وظیفه"
                                                outlined
                                                 dir="rtl"
                                                v-model="job"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="شماره تماس"
                                                outlined
                                                 dir="rtl"
                                                v-model="phoneNumber"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="تاریخ"
                                                outlined
                                                 dir="rtl"
                                                v-model="date"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="12">
                                            <v-text-field
                                                label="آدرس"
                                                outlined 
                                                 dir="rtl"
                                                v-model="address"
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
                                        @click="dialog2 = false , saveCrediator()"
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
                                    لیست طلبکاران
                             </v-toolbar-title> 
                            </v-toolbar>
                        </template>
                        </v-data-table>
                    </template>
                </v-container>
            </v-app>
        </v-flex> 

        <!-- Staff List and add Staff  -->

         <v-flex class="md9" v-show="StaffList" > 
            <v-app>
                <v-container>
                    <template>
                        <v-data-table  show-select item-key="id"
                         v-model="selected"
                        :headers="headers2"
                        :items="desserts2"   
                        :single-select="singleSelect"
                        :search="search"
                        class="style-table" 
                        style="color:darkgreen "
                        >
                        <template v-slot:top>
                            <v-toolbar flat>
                               <v-dialog v-model="dialog1" width="50%">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-btn color="success" dark  v-bind="attrs" v-on="on" >
                                    <v-icon left>add</v-icon>
                                    اضافه کردن
                                    </v-btn>
                                </template>

                                <v-card>
                                    <v-card-title  class="headline grey lighten-2" dir="rtl">
                                    اضافه نمودن شخص جدید
                                    </v-card-title>
                                    <v-card-text>
                                <v-form>
                                     <v-container>
                                        <v-row > 
                                            <v-col cols="12" sm="6" >
                                            <v-text-field
                                                label="نام "
                                                outlined
                                                dir="rtl"
                                                v-model="firstName"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="نام پدر"
                                                outlined
                                                 dir="rtl"
                                                v-model="fatherName"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label=" سن"
                                                outlined
                                                dir="rtl"
                                                v-model="age"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="درجه تحصیل"
                                                outlined
                                                dir="rtl"
                                                v-model="grade"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="وظیفه"
                                                outlined
                                                dir="rtl"
                                                v-model="job"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="حقوق"
                                                outlined
                                                dir="rtl"
                                                v-model="salary"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="مدت قرارداد"
                                                outlined
                                                dir="rtl"
                                                v-model="round"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="شماره تماس"
                                                outlined 
                                                dir="rtl"
                                                v-model="phoneNumber"
                                            ></v-text-field>
                                            </v-col>
                                              <v-col cols="12" sm="6">
                                              <v-text-field
                                                label="تاریخ شروع کار"
                                                outlined 
                                                dir="rtl"
                                                v-model="startWork"
                                            ></v-text-field>
                                            </v-col>
                                              <v-col cols="12" sm="12">
                                            <v-text-field
                                                label="آدرس"
                                                outlined 
                                                dir="rtl"
                                                v-model="address"
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
                                        @click="dialog1 = false "
                                    >
                                        انصراف
                                    </v-btn>
                                    <v-btn
                                        color="success"
                                        style="font-size:18px "
                                        @click="dialog1 = false , saveKarmand()"
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
                                    لیست کارمندان
                                </v-toolbar-title>
                            </v-toolbar>
                            
                        </template>
                        </v-data-table>
                    </template>
                </v-container>
            </v-app>
        </v-flex>
    


    <!-- this is for borrower list and add borrower -->

    <v-flex class="md16" v-show="BorrowerList"> 
            <v-app>
                <v-container>
                    <template>
                        <v-data-table 
                        v-model="selected"
                        :headers="headers"
                        :items="desserts"   
                        :single-select="singleSelect"
                        show-select
                        :search="search"
                        class="style-table" 
                        style="color:darkgreen ">
                        <template v-slot:top>
                            <v-toolbar flat>
                                 <v-dialog v-model="dialog" width="50%">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-btn color="success" dark  v-bind="attrs" v-on="on" >
                                    <v-icon left>add</v-icon>
                                    اضافه کردن
                                    </v-btn>
                                </template>

                                <v-card>
                                    <v-card-title  class="headline grey lighten-2" dir="rtl">
                                    اضافه نمودن شخص جدید
                                    </v-card-title>
                                    <v-card-text>
                                <v-form>
                                     <v-container>
                                        <v-row> 
                                            <v-col cols="12" sm="6" >
                                            <v-text-field
                                                label="نام "
                                                outlined
                                                dir="rtl"
                                                v-model="name"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="نام پدر"
                                                outlined
                                                dir="rtl"
                                                v-model="fathername"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="وظیفه"
                                                outlined
                                                dir="rtl"
                                                v-model="job"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="قرض"
                                                outlined
                                                dir="rtl"
                                                v-model="borrow"
                                            ></v-text-field>
                                            </v-col>
                                            <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="شماره تماس"
                                                outlined
                                                dir="rtl"
                                                v-model="phoneNumber"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="تاریخ "
                                                outlined
                                                dir="rtl"
                                                v-model="date"
                                            ></v-text-field>
                                            </v-col>
                                             <v-col cols="12" sm="6">
                                            <v-text-field
                                                label="آدرس"
                                                outlined
                                                dir="rtl"
                                                v-model="address"
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
                                        @click="dialog = false "
                                    >
                                        انصراف
                                    </v-btn>
                                    <v-btn
                                        color="success"
                                        style="font-size:18px "
                                        @click="  dialog = false  , saveborrower()"
                                    >
                                        ذخیره کردن
                                    </v-btn>
                                   
                                    </v-card-actions>
                                    </v-card>
                                 </v-dialog>
                                <v-spacer style="padding:2vh">
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
                                <v-toolbar-title class="ml-2 " style="color:red">
                                   لیست قرضداران
                                </v-toolbar-title>
                                </v-toolbar>
                            </template>
                        </v-data-table>
                    </template>
                </v-container>
            </v-app>
        </v-flex> 

  
      
</div>
</template>
<script>
import employee from "../api/Employee"
import borrower from "../api/borrower"
import Crediator from "../api/Crediator"
export default {
    
   data(){

  const employee={
            firstName:null,
            fatherName:null,
            age:null,
            grade:null,
            job:null,
            salary:null,
            round:null,
            phoneNumber:null,
            startWork:null,
            address:null
        } ;
        const Crediator={
            name:null,
            fathername:null,
            money:null,
            job:null,
            phoneNumber:null,
            date:null,
            address:null
        };
        const borrower={
            name:null,
            fathername:null,
            job:null,
            borrow:null,
            phoneNumber:null,
            date:null,
            address:null
        }  
    return {
       employee,
       borrower,
       Crediator,
       search: '',
       dialog:false,
       dialog1:false,
       dialog2:false,
       BorrowerList:false,
       CredaitorList:false,
       StaffList:false,
       singleSelect: false,
       selected: [],

        // This is for borrower list Data................
         headers: [
          {
            align: 'start',
            sortable: false,
            value: 'id',
            
          },
          { text: 'آدرس', value: 'address' },
          { text: 'تاریخ', value: 'date'  },
          { text: 'شماره تماس', value: 'phoneNumber'  },
          { text: 'قرض', value: 'borrow'  },
          {text:'شغل',value:'job'},
          {text:'نام پدر' , value:'fathername'},
          {text:'نام' , value:'name'}
          
        ],
        desserts: [],
        // This is for  Crediator list data.............................
          headers1: [
          {
            align: 'start',
            sortable: false,
            value: 'id',
            
          },
          { text: 'آدرس', value: 'address' },
          { text: 'تاریخ', value: 'date'  },
          { text: 'شماره تماس', value: 'phoneNumber'  },
          { text: 'شغل', value: 'job'  },
          {text:'مقدار پول',value:'money'},
          {text:'نام پدر' , value:'fathername'},
          {text:'نام' , value:'name'}
          
        ],
        desserts1: [{}],
       
    //    This is for Staff list data ...........................

      headers2: [
          {
            align: 'start',
            sortable: false,
            value: 'id',
            
          },
          { text: ' آدرس', value: 'address' },
          { text: ' تاریخ شروع کار', value: 'startWork' },
          { text: 'شماره تماس', value: 'phoneNumber' },
          { text: 'مدت قرارداد', value: 'round'  },
          { text: 'حقوق', value: 'salary'  },
          { text: 'شغل', value: 'job'  },
          {text:'درجه تحصیل',value:'grade'},
          {text:' سن',value:'age'},
          {text:'نام پدر' , value:'fatherName'},
          {text:'نام' , value:'firstName'}
          
        ],
        desserts2: [],
        
        }
        
       
   },

        // This is for borrower list Data .............................
       async mounted(){
           const response = await borrower.getAllborrower();
           this.desserts = response.data; 
        // This is for Crediator list Data .............................
            const response1 = await Crediator.getAllCrediator();
            this.desserts1 = response1.data; 
    //  This is for Staff list Data ................................  
             const response2 = await employee.getAllEmployee();
             this.desserts2 = response2.data;
   },

   methods:{

      showTableBorrwer(){
           this.BorrowerList =true;
           this.CredaitorList = false ;
           this.StaffList = false;
       },
       showTableCredaitor(){
           this.CredaitorList =true;
           this.BorrowerList = false;
           this.StaffList = false;
       },
        showTableStaff(){
           this.StaffList =true;
           this.CredaitorList = false;
           this.BorrowerList = false;
          
       },
       async saveKarmand(){
           const employee1={
               firstName : this.firstName,
               fatherName : this.fatherName,
               age:this.age,
               grade : this.grade,
               job : this.job,
               salary : this.salary,
               round : this.round,
               phoneNumber : this.phoneNumber,
               startWork : this.startWork,
               address : this.address
           }
           const response2= await employee.AddEmployee(employee1);
           console.log(response2);
            this.desserts2.push(response2.data);
       },
           async saveborrower(){
           const borrower1={
               name : this.name,
               fathername : this.fathername,
               job:this.job,
               borrow : this.borrow,
               phoneNumber:this.phoneNumber,
               date : this.date,
               address : this.address,
           }
           const response= await borrower.Addborrower(borrower1);
           console.log(response);
            this.desserts.push(response.data);
       },
        async saveCrediator(){
           const Crediaotr1={
               name : this.name,
               fathername : this.fathername,
               money:this.money,
               job : this.job,
               phoneNumber : this.phoneNumber,
               date : this.date,
               address : this.address
           }
           const response1= await Crediator.AddCrediator(Crediaotr1);
           console.log(response1);
            this.desserts1.push(response1.data);
       }
  
      

   }
}
</script>
<style>
.a{
    color:darkgreen
}
.style-table{
   text-underline-position: above;
}
</style>


