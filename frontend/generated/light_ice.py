# -*- coding: utf-8 -*-
#
# Copyright (c) ZeroC, Inc. All rights reserved.
#
#
# Ice version 3.7.10
#
# <auto-generated>
#
# Generated from file `light.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

from sys import version_info as _version_info_
import Ice, IcePy

# Start of module SmartHome
_M_SmartHome = Ice.openModule('generated.SmartHome')
__name__ = 'SmartHome'

_M_SmartHome._t_Light = IcePy.defineValue('::SmartHome::Light', Ice.Value, -1, (), False, True, None, ())

if 'LightPrx' not in _M_SmartHome.__dict__:
    _M_SmartHome.LightPrx = Ice.createTempClass()
    class LightPrx(Ice.ObjectPrx):

        def turnOn(self, context=None):
            return _M_SmartHome.Light._op_turnOn.invoke(self, ((), context))

        def turnOnAsync(self, context=None):
            return _M_SmartHome.Light._op_turnOn.invokeAsync(self, ((), context))

        def begin_turnOn(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHome.Light._op_turnOn.begin(self, ((), _response, _ex, _sent, context))

        def end_turnOn(self, _r):
            return _M_SmartHome.Light._op_turnOn.end(self, _r)

        def turnOff(self, context=None):
            return _M_SmartHome.Light._op_turnOff.invoke(self, ((), context))

        def turnOffAsync(self, context=None):
            return _M_SmartHome.Light._op_turnOff.invokeAsync(self, ((), context))

        def begin_turnOff(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHome.Light._op_turnOff.begin(self, ((), _response, _ex, _sent, context))

        def end_turnOff(self, _r):
            return _M_SmartHome.Light._op_turnOff.end(self, _r)

        def getState(self, context=None):
            return _M_SmartHome.Light._op_getState.invoke(self, ((), context))

        def getStateAsync(self, context=None):
            return _M_SmartHome.Light._op_getState.invokeAsync(self, ((), context))

        def begin_getState(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHome.Light._op_getState.begin(self, ((), _response, _ex, _sent, context))

        def end_getState(self, _r):
            return _M_SmartHome.Light._op_getState.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_SmartHome.LightPrx.ice_checkedCast(proxy, '::SmartHome::Light', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_SmartHome.LightPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::SmartHome::Light'
    _M_SmartHome._t_LightPrx = IcePy.defineProxy('::SmartHome::Light', LightPrx)

    _M_SmartHome.LightPrx = LightPrx
    del LightPrx

    _M_SmartHome.Light = Ice.createTempClass()
    class Light(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::SmartHome::Light')

        def ice_id(self, current=None):
            return '::SmartHome::Light'

        @staticmethod
        def ice_staticId():
            return '::SmartHome::Light'

        def turnOn(self, current=None):
            raise NotImplementedError("servant method 'turnOn' not implemented")

        def turnOff(self, current=None):
            raise NotImplementedError("servant method 'turnOff' not implemented")

        def getState(self, current=None):
            raise NotImplementedError("servant method 'getState' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_SmartHome._t_LightDisp)

        __repr__ = __str__

    _M_SmartHome._t_LightDisp = IcePy.defineClass('::SmartHome::Light', Light, (), None, ())
    Light._ice_type = _M_SmartHome._t_LightDisp

    Light._op_turnOn = IcePy.Operation('turnOn', Ice.OperationMode.Idempotent, Ice.OperationMode.Idempotent, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())
    Light._op_turnOff = IcePy.Operation('turnOff', Ice.OperationMode.Idempotent, Ice.OperationMode.Idempotent, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())
    Light._op_getState = IcePy.Operation('getState', Ice.OperationMode.Idempotent, Ice.OperationMode.Idempotent, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())

    _M_SmartHome.Light = Light
    del Light

# End of module SmartHome
