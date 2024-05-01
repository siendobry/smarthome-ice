//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `rgblight.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public interface RgbLightPrx extends LightPrx
{
    default Color getColor()
    {
        return getColor(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Color getColor(java.util.Map<String, String> context)
    {
        return _iceI_getColorAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Color> getColorAsync()
    {
        return _iceI_getColorAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Color> getColorAsync(java.util.Map<String, String> context)
    {
        return _iceI_getColorAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Color> _iceI_getColorAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Color> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getColor", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Color ret;
                     ret = Color.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default Color changeColor(RgbLightRequest request)
        throws InvalidColorRangeException,
               NonExistentPreset
    {
        return changeColor(request, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Color changeColor(RgbLightRequest request, java.util.Map<String, String> context)
        throws InvalidColorRangeException,
               NonExistentPreset
    {
        try
        {
            return _iceI_changeColorAsync(request, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidColorRangeException ex)
        {
            throw ex;
        }
        catch(NonExistentPreset ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Color> changeColorAsync(RgbLightRequest request)
    {
        return _iceI_changeColorAsync(request, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Color> changeColorAsync(RgbLightRequest request, java.util.Map<String, String> context)
    {
        return _iceI_changeColorAsync(request, context, false);
    }

    /**
     * @hidden
     * @param iceP_request -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Color> _iceI_changeColorAsync(RgbLightRequest iceP_request, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Color> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "changeColor", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_changeColor);
        f.invoke(true, context, null, ostr -> {
                     RgbLightRequest.ice_write(ostr, iceP_request);
                 }, istr -> {
                     Color ret;
                     ret = Color.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_changeColor =
    {
        InvalidColorRangeException.class,
        NonExistentPreset.class
    };

    default java.util.Map<java.lang.String, Color> getPresets()
    {
        return getPresets(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default java.util.Map<java.lang.String, Color> getPresets(java.util.Map<String, String> context)
    {
        return _iceI_getPresetsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.util.Map<java.lang.String, Color>> getPresetsAsync()
    {
        return _iceI_getPresetsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.util.Map<java.lang.String, Color>> getPresetsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPresetsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.util.Map<java.lang.String, Color>> _iceI_getPresetsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.util.Map<java.lang.String, Color>> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPresets", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     java.util.Map<java.lang.String, Color> ret;
                     ret = ColorPresetsHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default void addPreset(String name, Color color)
        throws InvalidColorRangeException
    {
        addPreset(name, color, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void addPreset(String name, Color color, java.util.Map<String, String> context)
        throws InvalidColorRangeException
    {
        try
        {
            _iceI_addPresetAsync(name, color, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidColorRangeException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> addPresetAsync(String name, Color color)
    {
        return _iceI_addPresetAsync(name, color, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> addPresetAsync(String name, Color color, java.util.Map<String, String> context)
    {
        return _iceI_addPresetAsync(name, color, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param iceP_color -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_addPresetAsync(String iceP_name, Color iceP_color, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "addPreset", null, sync, _iceE_addPreset);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                     Color.ice_write(ostr, iceP_color);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_addPreset =
    {
        InvalidColorRangeException.class
    };

    default void editPreset(String name, Color color)
        throws InvalidColorRangeException
    {
        editPreset(name, color, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void editPreset(String name, Color color, java.util.Map<String, String> context)
        throws InvalidColorRangeException
    {
        try
        {
            _iceI_editPresetAsync(name, color, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidColorRangeException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> editPresetAsync(String name, Color color)
    {
        return _iceI_editPresetAsync(name, color, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> editPresetAsync(String name, Color color, java.util.Map<String, String> context)
    {
        return _iceI_editPresetAsync(name, color, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param iceP_color -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_editPresetAsync(String iceP_name, Color iceP_color, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "editPreset", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_editPreset);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                     Color.ice_write(ostr, iceP_color);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_editPreset =
    {
        InvalidColorRangeException.class
    };

    default void removePreset(String name)
    {
        removePreset(name, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void removePreset(String name, java.util.Map<String, String> context)
    {
        _iceI_removePresetAsync(name, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> removePresetAsync(String name)
    {
        return _iceI_removePresetAsync(name, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> removePresetAsync(String name, java.util.Map<String, String> context)
    {
        return _iceI_removePresetAsync(name, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_removePresetAsync(String iceP_name, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "removePreset", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                 }, null);
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RgbLightPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RgbLightPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RgbLightPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RgbLightPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static RgbLightPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static RgbLightPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, RgbLightPrx.class, _RgbLightPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default RgbLightPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (RgbLightPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default RgbLightPrx ice_adapterId(String newAdapterId)
    {
        return (RgbLightPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default RgbLightPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (RgbLightPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default RgbLightPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (RgbLightPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default RgbLightPrx ice_invocationTimeout(int newTimeout)
    {
        return (RgbLightPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default RgbLightPrx ice_connectionCached(boolean newCache)
    {
        return (RgbLightPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default RgbLightPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (RgbLightPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RgbLightPrx ice_secure(boolean b)
    {
        return (RgbLightPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default RgbLightPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (RgbLightPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RgbLightPrx ice_preferSecure(boolean b)
    {
        return (RgbLightPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default RgbLightPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (RgbLightPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default RgbLightPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (RgbLightPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default RgbLightPrx ice_collocationOptimized(boolean b)
    {
        return (RgbLightPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default RgbLightPrx ice_twoway()
    {
        return (RgbLightPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default RgbLightPrx ice_oneway()
    {
        return (RgbLightPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default RgbLightPrx ice_batchOneway()
    {
        return (RgbLightPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default RgbLightPrx ice_datagram()
    {
        return (RgbLightPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default RgbLightPrx ice_batchDatagram()
    {
        return (RgbLightPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default RgbLightPrx ice_compress(boolean co)
    {
        return (RgbLightPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default RgbLightPrx ice_timeout(int t)
    {
        return (RgbLightPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default RgbLightPrx ice_connectionId(String connectionId)
    {
        return (RgbLightPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default RgbLightPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (RgbLightPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::RgbLight";
    }
}