package com.ojas.myordersdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojas.myordersdemo.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: OrdersAdapter
    private var allOrders: List<Order> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDummyData()
        setupRecyclerView()
        setupTabs()
        setupBanner()
    }

    private fun setupDummyData() {
        allOrders = listOf(
            Order(
                orderId = "ORD12345",
                vehicleType = "Four Wheeler",
                dateTime = "05 Feb, 4:46 PM",
                pickupAddress = "741, Gumanwara",
                dropAddress = "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh 284001, India",
                price = 229.0,
                status = "CANCELLED"
            ),
            Order(
                orderId = "ORD12346",
                vehicleType = "Four Wheeler",
                dateTime = "05 Feb, 4:46 PM",
                pickupAddress = "741, Gumanwara",
                dropAddress = "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh 284001, India",
                price = 229.0,
                status = "CANCELLED"
            ),
            Order(
                orderId = "ORD12347",
                vehicleType = "Four Wheeler",
                dateTime = "05 Feb, 4:46 PM",
                pickupAddress = "332, Gumanwara",
                dropAddress = "GC72+GGV, Kamrari, Madhya Pradesh 475661, India",
                price = 1515.0,
                status = "CANCELLED"
            ),
            Order(
                orderId = "ORD12348",
                vehicleType = "Four Wheeler",
                dateTime = "05 Feb, 4:46 PM",
                pickupAddress = "332, Gumanwara",
                dropAddress = "GC72+GGV, Kamrari, Madhya Pradesh 475661, India",
                price = 1634.0,
                status = "CANCELLED"
            ),
            Order(
                orderId = "ORD12349",
                vehicleType = "Four Wheeler",
                dateTime = "06 Feb, 10:00 AM",
                pickupAddress = "12, Civil Lines, Jhansi",
                dropAddress = "Sector 5, Noida, Uttar Pradesh 201301, India",
                price = 850.0,
                status = "COMPLETED"
            ),
            Order(
                orderId = "ORD12350",
                vehicleType = "Four Wheeler",
                dateTime = "07 Feb, 2:30 PM",
                pickupAddress = "45, Gandhi Nagar, Jhansi",
                dropAddress = "Bhopal Junction, Madhya Pradesh 462001, India",
                price = 1200.0,
                status = "COMPLETED"
            )
        )
    }

    private fun setupRecyclerView() {
        adapter = OrdersAdapter(allOrders)
        binding.recyclerOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerOrders.adapter = adapter
    }

    private fun setupTabs() {
        // set initial active tab
        setActiveTab(binding.tabAllOrders)

        binding.tabAllOrders.setOnClickListener {
            setActiveTab(it as TextView)
            adapter.updateOrders(allOrders)
        }

        binding.tabCompleted.setOnClickListener {
            setActiveTab(it as TextView)
            adapter.updateOrders(allOrders.filter { order ->
                order.status == "COMPLETED"
            })
        }

        binding.tabCancelled.setOnClickListener {
            setActiveTab(it as TextView)
            adapter.updateOrders(allOrders.filter { order ->
                order.status == "CANCELLED"
            })
        }

        binding.tabBookedAgain.setOnClickListener {
            setActiveTab(it as TextView)
            adapter.updateOrders(allOrders.filter { order ->
                order.status == "BOOKED_AGAIN"
            })
        }
    }

    private fun setActiveTab(activeTab: TextView) {
        // reset all tabs
        val tabs = listOf(
            binding.tabAllOrders,
            binding.tabCompleted,
            binding.tabCancelled,
            binding.tabBookedAgain
        )

        tabs.forEach { tab ->
            tab.setBackgroundResource(R.drawable.bg_tab_inactive)
            tab.setTextColor(requireContext().getColor(R.color.tab_inactive_text))
            tab.textStyle(false)
        }

        // set active tab
        activeTab.setBackgroundResource(R.drawable.bg_yellow_pill)
        activeTab.setTextColor(requireContext().getColor(R.color.text_dark))
        activeTab.textStyle(true)
    }

    private fun TextView.textStyle(bold: Boolean) {
        this.setTypeface(
            null,
            if (bold) android.graphics.Typeface.BOLD
            else android.graphics.Typeface.NORMAL
        )
    }

    private fun setupBanner() {
        binding.btnDismissBanner.setOnClickListener {
            binding.infoBanner.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}