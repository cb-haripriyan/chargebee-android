package com.chargebee.android.models

import com.chargebee.android.CBResult
import com.chargebee.android.exceptions.InvalidRequestException
import com.chargebee.android.exceptions.OperationFailedException
import com.chargebee.android.loggers.CBLogger
import com.chargebee.android.resources.PlanResource

data class Plan(
    val id: String,
    val name: String,
    val invoiceName: String,
    val price: Int,
    val period: Int,
    val periodUnit: String,
    val pricingModel: String,
    val freeQuantity: Int,
    val setup_cost: Int,
    val status: String,
    val enabledInHostedPages: Boolean,
    val enabledInPortal: Boolean,
    val addonApplicability: String,
    val isShippable: Boolean,
    val updatedAt: Long,
    val giftable: Boolean,
    val resourceVersion: Long,
    val `object`: String,
    val chargeModel: String,
    val taxable: Boolean,
    val currencyCode: String,
    val showDescriptionInInvoices: Boolean,
    val showDescriptionInQuotes: Boolean
) {
    companion object {
        @JvmStatic
        @Throws(InvalidRequestException::class, OperationFailedException::class)
        fun retrieve(planId: String, completion: (CBResult<Plan>) -> Unit) {
            val logger = CBLogger(name = "plan", action = "retrieve_plan")
            ResultHandler.safeExecute({ PlanResource().retrieve(planId) }, completion, logger)
        }

    }
}

internal data class PlanWrapper(val plan: Plan)
