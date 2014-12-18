/*
 * --------------------------------------------------------------------------
 * COPYRIGHT Ericsson Telecommunicatie B.V., 2014
 * All rights reserved
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Telecommunicatie B.V.. The programs may be used and/or
 * copied only with written permission from Ericsson Telecommunicatie
 * B.V. or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program(s) have been supplied.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT ARE DISCLAIMED.
 * ERICSSON TELECOMMUNICATIE B.V. SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 * --------------------------------------------------------------------------
 */

/**
 * NomtOperation.java
 *
 * @author Rain Tang
 *         Dec 18, 2014 5:06:43 PM
 * @description
 */
package org.nomt.base.operation;

/**
 * @author Rain Tang
 *
 */
public enum NomtOperation
{

    QUERY_ALIVE, // 查询是否在线
    SYNC_STATIC_INFO, // 同步设备静态信息
    SYNC_PEFORM_INFO // 同步设备性能数据
    ;

}
