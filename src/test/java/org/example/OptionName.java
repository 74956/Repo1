package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionName {

    CONDITION("Condition"),
    CLIMATE_PLEDGE_FRIENDLY("Climate Pledge Friendly"),
    DEPARTMENT("Department"),
    CUSTOMER_REVIEWS("Customer Reviews"),
    BRAND("Brand"),
    CELL_PHONE_PRICE("Cell Phone Price"),
    CELL_PHONE_CARRIER("Cell Phone Carrier"),
    ELECTRONICS_DEVICE_MODEL_YEAR("Electronics Device Model Year"),
    PHONE_COLOR("Phone Color"),
    CELL_PHONE_INTERNAL_STORAGE_MEMORY("Cell Phone Internal Storage Memory"),
    CELL_PHONE_DISPLAY_SIZE("Cell Phone Display Size"),
    CELL_PHONE_ASPECT_RATIO("Cell Phone Aspect Ratio"),
    CELLULAR_TECHNOLOGY("Cellular Technology"),
    CELL_PHONE_OPERATION_SYSTEM("Cell Phone Operating System"),
    CELLULAR_PHONE_FORM_FACTOR("Cellular Phone Form Factor"),
    CELLULAR_PHONE_SIM_CARD_SIZE("Cellular Phone SIM Card Size"),
    CELL_PHONE_CONNECTIVITY_TECHNOLOGY("Cell Phone Connectivity Technology"),
    CELL_PHONE_FEATURES("Cell Phone Features"),
    CELL_PHONE_DISPLAY_TYPE("Cell Phone Display Type"),
    CELL_PHONE_CAMERA_RESOLUTION("Cell Phone Camera Resolution"),
    CELL_PHONE_SHOOTING_MODES("Cell Phone Shooting Modes"),
    CELLULAR_PHONE_BIOMETRIC_SECURITY_FEATURE("Cellular Phone Biometric Security Feature"),
    CELL_PHONE_HUMAN_INTERFACE_INPUT("Cell Phone Human Interface Input"),
    CELLULAR_PHONE_SIM_CARD_SLOT_COUNT("Cellular Phone SIM Card Slot Count"),
    CELL_PHONE_CONNECTOR_TYPE("Cell Phone Connector Type"),
    CELL_PHONE_RESOLUTION("Cell Phone Resolution"),
    WATER_RESISTANCE_LEVEL("Water Resistance Level"),
    AVAILABILITY("Availability");

    private final String optionName;

}
