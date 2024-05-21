#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.customer;

/**
 * CompanyType
 */
public enum CompanyType {
    POTENTIAL,
    INTENTIONAL,
    IMPORTANT,
    VIP;
}
