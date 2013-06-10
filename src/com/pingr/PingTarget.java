/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.pingr;

import java.net.InetAddress;

import android.content.SharedPreferences;

/**
 * Ping target info
 * 
 * @author bharddee
 * 
 */
public class PingTarget {

	public static enum STATUS {
		GREEN, YELLOW, ORANGE, RED, PING_IN_PROGRESS
	};

	private InetAddress mAddress;
	private String mHostname;
	private STATUS mStatus;

	private float mRttAvg; // in ms
	private float mRttMin;
	private float mRttMax;
	private float mRttStdDev; // unused

	/**
	 * @return the mRttAvg
	 */
	public float getRttAvg() {
		return mRttAvg;
	}

	/**
	 * @param mRttAvg
	 *            the mRttAvg to set
	 */
	public void setRttAvg(float mRttAvg) {
		this.mRttAvg = mRttAvg;		
		if (this.mRttAvg < (float)PingActivity.greenThreshold){
			this.mStatus = STATUS.GREEN;
		}
		else if (this.mRttAvg < (float)PingActivity.orangeThreshold){
			this.mStatus = STATUS.ORANGE;
		}
		else {
			this.mStatus = STATUS.RED;
		}
	}

	/**
	 * @return the mRttMin
	 */
	public float getRttMin() {
		return mRttMin;
	}

	/**
	 * @param mRttMin
	 *            the mRttMin to set
	 */
	public void setRttMin(float mRttMin) {
		this.mRttMin = mRttMin;
	}

	/**
	 * @return the mRttMax
	 */
	public float getRttMax() {
		return mRttMax;
	}

	/**
	 * @param mRttMax
	 *            the mRttMax to set
	 */
	public void setRttMax(float mRttMax) {
		this.mRttMax = mRttMax;
	}

	/**
	 * @return the mAddress
	 */
	public InetAddress getAddress() {
		return mAddress;
	}

	/**
	 * @param mAddress
	 *            the mAddress to set private
	 */
	public void setAddress(InetAddress mAddress) {
		this.mAddress = mAddress;
	}

	/**
	 * @return the mHostname
	 */
	public String getHostname() {
		return mHostname;
	}

	/**
	 * @param mHostname
	 *            the mHostname to set
	 */
	public void setHostname(String mHostname) {
		this.mHostname = mHostname;
	}

	/**
	 * @return the mStatus
	 */
	public STATUS getStatus() {
		return mStatus;
	}

	public PingTarget(String mHostname) {
		super();
		this.mHostname = mHostname;
		this.mStatus = STATUS.PING_IN_PROGRESS;
	}

	@Override
	public boolean equals(Object o) {
		PingTarget in = (PingTarget) o;
		if (this.getHostname() == in.getHostname()) {
			return true;

		} else
			return false;
	}
}
