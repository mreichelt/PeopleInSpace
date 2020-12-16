package com.surrus.common.repository

import co.touchlab.kermit.Logger
import co.touchlab.kermit.NSLogLogger

actual fun getLogger(): Logger = NSLogLogger()