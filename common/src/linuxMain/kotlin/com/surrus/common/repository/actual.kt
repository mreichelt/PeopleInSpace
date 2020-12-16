package com.surrus.common.repository

import co.touchlab.kermit.Logger
import co.touchlab.kermit.CommonLogger

actual fun getLogger(): Logger = CommonLogger()
