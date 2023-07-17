package com.example.demo.system

import com.example.demo.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("Products")
class ProductsController(private val productService: ProductService)
{
    @GetMapping
    fun getAll()
    {
        productService.all()
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody product: Product)
    {
        productService.add(product)
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id:Long,@RequestBody product: Product)
    {
        productService.edit(id,product)

        @DeleteMapping("{id}")
        fun delete (@PathVariable id: Product)
        {
            productService.remove(id)
        }
    }
}
