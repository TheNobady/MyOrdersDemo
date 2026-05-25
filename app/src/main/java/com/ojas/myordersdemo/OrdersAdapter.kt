package com.ojas.myordersdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ojas.myordersdemo.databinding.ItemOrderBinding

class OrdersAdapter(
    private var orders: List<Order>
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(
        private val binding: ItemOrderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.tvVehicleType.text = order.vehicleType
            binding.tvDateTime.text = "${order.dateTime}  |  Order ID: #${order.orderId}"
            binding.tvPickupAddress.text = order.pickupAddress
            binding.tvDropAddress.text = order.dropAddress
            binding.tvPrice.text = "₹ ${order.price}"
            binding.tvStatus.text = order.status

            // status badge color
            when (order.status) {
                "CANCELLED" -> {
                    binding.tvStatus.visibility = View.VISIBLE
                    binding.tvStatus.setTextColor(
                        binding.root.context.getColor(R.color.cancelled_red)
                    )
                    binding.tvStatus.setBackgroundResource(R.drawable.bg_cancelled_badge)
                }
                "COMPLETED" -> {
                    binding.tvStatus.visibility = View.VISIBLE
                    binding.tvStatus.setTextColor(
                        binding.root.context.getColor(R.color.pickup_green)
                    )
                    binding.tvStatus.setBackgroundResource(R.drawable.bg_cancelled_badge)
                }
                else -> {
                    binding.tvStatus.visibility = View.GONE
                }
            }

            // button click listeners
            binding.btnInvoice.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Downloading invoice for ${order.orderId}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.btnBookAgain.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Booking again for ${order.orderId}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.ivMoreOptions.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "More options for ${order.orderId}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int = orders.size

    // call this from fragment when tab changes
    fun updateOrders(newOrders: List<Order>) {
        orders = newOrders
        notifyDataSetChanged()
    }
}