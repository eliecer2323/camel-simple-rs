package com.olive.integration.routingsystem.dtos;

import org.apache.camel.component.salesforce.api.dto.AbstractSObjectBase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyFordSF extends AbstractSObjectBase {
	@JsonProperty("AccountNet_Number__c")
	private String AccountNet_Number__c;

	@JsonProperty("Policy_Number__c")
	private String Policy_Number__c;
	
	@JsonProperty("Paylink_Finance_Fee__c")
	private Double Paylink_Finance_Fee__c;
	
	@JsonProperty("VIN__c")
	private String VIN__c;
	
	@JsonProperty("Ford_Contract_Number__c")
	private String Ford_Contract_Number__c;
	
	@JsonProperty("Plan_Number__c")
	private String Plan_Number__c;
	
	@JsonProperty("Return_Commission__c")
	private Double Return_Commission__c;
	
	@JsonProperty("Policy_Status__c")
	private String Policy_Status__c;
	
	@JsonProperty("Funded_Amount__c")
	private Double Funded_Amount__c;
	
	@JsonProperty("Funded__c")
	private Boolean Funded__c;
	
	@JsonProperty("Dealer_Cost_change__c")
	private Double Dealer_Cost_change__c;
	
	@JsonProperty("Amendment_change__c")
	private Double Amendment_change__c;
	
//	@JsonProperty("Is_Paid_in_Full__c")
//	private Double Is_Paid_in_Full__c;

	public PolicyFordSF() {
		getAttributes().setType("Policy__c");
	}

	public String getAccountNet_Number__c() {
		return AccountNet_Number__c;
	}

	public void setAccountNet_Number__c(String accountNet_Number__c) {
		AccountNet_Number__c = accountNet_Number__c;
	}

	public String getPolicy_Number__c() {
		return Policy_Number__c;
	}

	public void setPolicy_Number__c(String policy_Number__c) {
		Policy_Number__c = policy_Number__c;
	}

	public Double getPaylink_Finance_Fee__c() {
		return Paylink_Finance_Fee__c;
	}

	public void setPaylink_Finance_Fee__c(Double paylink_Finance_Fee__c) {
		Paylink_Finance_Fee__c = paylink_Finance_Fee__c;
	}

	public String getVIN__c() {
		return VIN__c;
	}

	public void setVIN__c(String vIN__c) {
		VIN__c = vIN__c;
	}

	public String getFord_Contract_Number__c() {
		return Ford_Contract_Number__c;
	}

	public void setFord_Contract_Number__c(String ford_Contract_Number__c) {
		Ford_Contract_Number__c = ford_Contract_Number__c;
	}

	public String getPlan_Number__c() {
		return Plan_Number__c;
	}

	public void setPlan_Number__c(String plan_Number__c) {
		Plan_Number__c = plan_Number__c;
	}

	public Double getReturn_Commission__c() {
		return Return_Commission__c;
	}

	public void setReturn_Commission__c(Double return_Commission__c) {
		Return_Commission__c = return_Commission__c;
	}

	public String getPolicy_Status__c() {
		return Policy_Status__c;
	}

	public void setPolicy_Status__c(String policy_Status__c) {
		Policy_Status__c = policy_Status__c;
	}

	public Double getFunded_Amount__c() {
		return Funded_Amount__c;
	}

	public void setFunded_Amount__c(Double funded_Amount__c) {
		Funded_Amount__c = funded_Amount__c;
	}

	public Boolean getFunded__c() {
		return Funded__c;
	}

	public void setFunded__c(Boolean funded__c) {
		Funded__c = funded__c;
	}

	public Double getDealer_Cost_change__c() {
		return Dealer_Cost_change__c;
	}

	public void setDealer_Cost_change__c(Double dealer_Cost_change__c) {
		Dealer_Cost_change__c = dealer_Cost_change__c;
	}

	public Double getAmendment_change__c() {
		return Amendment_change__c;
	}

	public void setAmendment_change__c(Double amendment_change__c) {
		Amendment_change__c = amendment_change__c;
	}

//	public Double getIs_Paid_in_Full__c() {
//		return Is_Paid_in_Full__c;
//	}
//
//	public void setIs_Paid_in_Full__c(Double is_Paid_in_Full__c) {
//		Is_Paid_in_Full__c = is_Paid_in_Full__c;
//	}
	
}
