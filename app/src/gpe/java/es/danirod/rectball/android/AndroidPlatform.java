/*
 * This file is part of Rectball
 * Copyright (C) 2015-2017 Dani Rodríguez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.danirod.rectball.android;

import android.content.Intent;

/**
 * This contains code for the Android platform. Here code that uses Android
 * SDK or Android API might be used. This code won't run on other platforms
 * than Android.
 *
 * @author danirod
 * @since 0.4.0
 */
class AndroidPlatform extends AbstractPlatform {

    final GooglePlayGamesRuntime gpg;

    final GoogleAnalyticsRuntime ga;

    protected AndroidPlatform(AndroidLauncher context) {
        super(context);
        gpg = new GooglePlayGamesRuntime(context);
        ga = new GoogleAnalyticsRuntime(context);
    }

    @Override
    public GameServices getGameServices() {
        return gpg;
    }

    @Override
    public Analytics getAnalytics() {
        return ga;
    }

    @Override
    public void onStart() {
        gpg.gameHelper.onStart(context);
    }

    @Override
    public void onStop() {
        gpg.gameHelper.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        gpg.gameHelper.onActivityResult(requestCode, resultCode, data);
    }
}
