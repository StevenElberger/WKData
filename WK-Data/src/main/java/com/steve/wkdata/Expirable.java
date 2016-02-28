package com.steve.wkdata;

/**
 * Interface for expirable information.
 * @author Steve
 */
public interface Expirable {
  /**
   * Checks if the data has expired.
   * @return true if expired, false otherwise
   */
  public boolean isExpired();
}
