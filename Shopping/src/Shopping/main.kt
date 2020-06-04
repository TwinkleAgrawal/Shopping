package Shopping

fun main(args:Array<String>)
{  customer()
    val customer_x= MyStore
    var items_list= customer_x.items()
    //customer_x.display(items_list) //display using extension function.Uncomment it to see its functioning
    //example of lambda function
    customer_x.run {
        purchase(items_list)
    }
}//end of main function
//sample of extension function to display all elements of a items
fun MyStore.display(displayItems: List<Items_Store>){for (i in 0..displayItems.size - 1)
    println("${i + 1}-->${displayItems.get(i).itemname}-->${displayItems.get(i).instore}-->${displayItems.get(i).cost}")
}//end of entension function

fun customer() //java interoperability
{var Myname=Customer()
    val welcome:String="Welcome!Have  a good day!!\nPlease enter your Name" //string templates
    println(welcome)
    var name= readLine()
    Myname.setName(name)
    println("Hello ${Myname.getName()}!!!Welcome to ABC shopping ")
}//end of customer


