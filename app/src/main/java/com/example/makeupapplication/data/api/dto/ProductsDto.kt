package com.example.makeupapplication.data.api.dto

import com.google.gson.annotations.SerializedName

data class ProductsDto(

	@field:SerializedName("ProductsDto")
	val productsDto: List<ProductsDtoItem>? = null
)

data class ProductsDtoItem(

	@field:SerializedName("website_link")
	val websiteLink: String? = null,

	@field:SerializedName("image_link")
	val imageLink: String? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("api_featured_image")
	val apiFeaturedImage: String? = null,

	@field:SerializedName("product_type")
	val productType: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("tag_list")
	val tagList: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("price_sign")
	val priceSign: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("product_colors")
	val productColors: List<ProductColorsItem?>? = null,

	@field:SerializedName("brand")
	val brand: String? = null,

	@field:SerializedName("product_api_url")
	val productApiUrl: String? = null,

	@field:SerializedName("product_link")
	val productLink: String? = null
)

data class ProductColorsItem(

	@field:SerializedName("colour_name")
	val colourName: String? = null,

	@field:SerializedName("hex_value")
	val hexValue: String? = null
)

