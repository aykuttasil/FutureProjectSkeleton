package com.aykuttasil.futureprojectskeleton.data.model

import com.aykuttasil.futureprojectskeleton.data.AppDatabase
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table

@Table(database = AppDatabase::class)
data class ModelPaket(@PrimaryKey var ad: String? = null, var cins: String? = null, var gonderenAd: String? = null)
