@file:Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")

package Shopping

import kotlin.io.readLine as readLine

data class Items_Store( var itemname:String,var instore:Int?=0,var cost: Float =0.0F) //data class
//object class as its only one object is to be created
object MyStore {   //start of object class MyStore

    fun items(): List<Items_Store> {
        val listitems: List<Items_Store> = mutableListOf(
            Items_Store("Rice", 100, 50F),
            Items_Store("milk", 10, 45F),
            Items_Store("Bath-soap", 12, 24F),
            Items_Store("wheat", 50, 56.5F),
            Items_Store("Dairy Milk", 12, 25F),
            Items_Store("dishwash", 15, 34.68F),
            Items_Store("Deodrants", 6, 120F),
            Items_Store("Talcum powder", 8, 67F),
            Items_Store("Biscuits", 25, 12F),
            Items_Store("Cream-biscuit", 12, 20F),
            Items_Store("Hair-oil", 6, 34.0F),
            Items_Store("Body-Cream", 4, 95.0F),
            Items_Store("Cooking-oil", 40, 60.0F)
        )
        return listitems
    }//end of items (contains all the elements present at store)
    //--------------------------------------------------------------------------------------------------
    fun purchase(items: List<Items_Store>) {
        var calculate: Float? = 0F
        var ch: Char ='y'
        var total= mutableListOf<Items_Store>()
        while (ch == 'y') {
            displayAll(items)
            println("\nPlease enter the product number  and quantity to add it to your cart")
            var item_no:Int=readLine()!!.toInt()
            var item =items[item_no-1].itemname
            println("Enter the quantity of $item you want")
            var quantity = readLine()!!.toInt()
            //lambda function
            //using this method also i get the contents of selected object (method 1)
            var index=items.find{
                it.itemname.equals(item,ignoreCase = true)
            }
            //var index=list_index(items, item!!)
            var cost = index?.cost
            var quan = index?.instore
            if(quan==0){
                println("Sorry it is out of stock!want to purchase anything else(y/n)")
                ch= readLine()!!.first()
                continue}
            else if (quantity > quan!!) {
                println("This much stock not available at present")
                println("Stock available is $quan, So enter the quantity you want of $item")
                quantity = readLine()!!.toInt()
            }
            //using this method also i get the contents of selected object (method 2)
            var it= list_index(items, item!!)
            items[it].instore=quan-quantity

            if (calculate != null) if (cost != null) calculate += (cost * quantity) //null safety
            total.add(Items_Store(item,quantity,cost!!))
            Bill(total)
            println("want to purchase more items!!!!(y/n)")
            ch = readLine()!!.first()
        }
        println(message = "Your bill is $calculate")
        println("Thank you for visiting us!!!\n\tVisit Again\t")
    }//end of purchase(makes the customer select the item and quantity and displays the bill)
    //---------------------------------------------------------------------------------------------
    fun displayAll(displayItems: List<Items_Store>) {
        println("name-->instock-->cost")
        for (i in 0..displayItems.size - 1) {
            var name = displayItems.get(i).itemname
            var instock = displayItems.get(i).instore
            var cost = displayItems.get(i).cost
            if((i+1)%2!=0) print("${i + 1}->$name-->$instock-->$cost\t")
            else println("${i + 1}-->$name-->$instock-->$cost")
        }
    }//end of display(displays all the products at store and updates the values of the product once purchased)
    //------------------------------------------------------------------------------------------
    fun list_index(li:List<Items_Store>,name:String):Int{
        var ind=0
        for (i in 0..li.size-1)
            if(li.get(i).itemname.equals(name,ignoreCase = true)){ind=i
                break}
        return ind
    }//end of list_index(returns the index of element)
    //----------------------------------------------------------------------
    fun Bill(bill_all:MutableList<Items_Store>) {
        var size: Int = bill_all.size
        println("Your purchased items are:-")
        for (i in 0..size - 1) {
            var amount = bill_all.get(i).instore?.times(bill_all.get(i).cost)
            println("${i + 1}-->${bill_all.get(i).itemname}\t${bill_all.get(i).instore}*${bill_all.get(i).cost} = $amount")
        }
    }//end of bill(displays products purchased)

}

